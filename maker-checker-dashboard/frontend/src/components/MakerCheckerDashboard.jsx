import React, { useState, useEffect } from 'react';
import './MakerCheckerDashboard.css';

export default function MakerCheckerDashboard({ userRole, userId }) {
  const [products, setProducts] = useState([]);
  const [pendingApprovals, setPendingApprovals] = useState([]);
  const [form, setForm] = useState({
    product_id: '',
    product_code: '',
    rate_of_intrest: '',
    effective_from_date: '',
    effective_to_date: '',
    is_active: false,
  });
  const [comment, setComment] = useState('');

  useEffect(() => {
    if (userRole === 'maker') {
      fetch(`/api/products/maker/${userId}`)
        .then(res => res.json())
        .then(setProducts);
    } else if (userRole === 'checker') {
      fetch(`/api/products/checker/${userId}`)
        .then(res => res.json())
        .then(setPendingApprovals);
    }
  }, [userRole, userId]);

  const handleSubmit = e => {
    e.preventDefault();
    fetch('/api/products/submit', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ ...form, maker_id: userId }),
    })
      .then(() => window.location.reload());
  };

  const handleDecision = (approvalId, status) => {
    fetch('/api/products/decide', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        approval_id: approvalId,
        status,
        comments: comment,
        checker_id: userId,
      }),
    })
      .then(() => window.location.reload());
  };

  return (
    <div className="dashboard">
      {userRole === 'maker' ? (
        <>
          <h2>Submit Product for Approval</h2>
          <form onSubmit={handleSubmit}>
            <input
              placeholder="Product ID"
              value={form.product_id}
              onChange={e => setForm({ ...form, product_id: e.target.value })}
              required
            />
            <input
              placeholder="Product Code"
              value={form.product_code}
              onChange={e => setForm({ ...form, product_code: e.target.value })}
              required
            />
            <input
              type="number"
              step="0.01"
              placeholder="Rate of Interest"
              value={form.rate_of_intrest}
              onChange={e => setForm({ ...form, rate_of_intrest: e.target.value })}
              required
            />
            <input
              type="date"
              placeholder="Effective From Date"
              value={form.effective_from_date}
              onChange={e => setForm({ ...form, effective_from_date: e.target.value })}
              required
            />
            <input
              type="date"
              placeholder="Effective To Date"
              value={form.effective_to_date}
              onChange={e => setForm({ ...form, effective_to_date: e.target.value })}
              required
            />
            <label>
              <input
                type="checkbox"
                checked={form.is_active}
                onChange={e => setForm({ ...form, is_active: e.target.checked })}
              />
              Is Active
            </label>
            <button type="submit">Submit for Approval</button>
          </form>
          <h3>My Submissions</h3>
          <table>
            <thead>
              <tr>
                <th>Product ID</th>
                <th>Product Code</th>
                <th>Rate of Interest</th>
                <th>Effective From Date</th>
                <th>Effective To Date</th>
                <th>Is Active</th>
                <th>Status</th>
                <th>Checker Comments</th>
              </tr>
            </thead>
            <tbody>
              {products.map(p => (
                <tr key={p.approval_id}>
                  <td>{p.product_id}</td>
                  <td>{p.product_code}</td>
                  <td>{p.rate_of_intrest}</td>
                  <td>{p.effective_from_date}</td>
                  <td>{p.effective_to_date}</td>
                  <td>{p.is_active ? 'Yes' : 'No'}</td>
                  <td>{p.status}</td>
                  <td>{p.comments}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      ) : (
        <>
          <h2>Pending Approvals</h2>
          <table>
            <thead>
              <tr>
                <th>Product ID</th>
                <th>Product Code</th>
                <th>Rate of Interest</th>
                <th>Effective From Date</th>
                <th>Effective To Date</th>
                <th>Is Active</th>
                <th>Maker ID</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {pendingApprovals.map(a => (
                <tr key={a.approval_id}>
                  <td>{a.product_id}</td>
                  <td>{a.product_code}</td>
                  <td>{a.rate_of_intrest}</td>
                  <td>{a.effective_from_date}</td>
                  <td>{a.effective_to_date}</td>
                  <td>{a.is_active ? 'Yes' : 'No'}</td>
                  <td>{a.maker_id}</td>
                  <td>
                    <input
                      placeholder="Comments"
                      value={comment}
                      onChange={e => setComment(e.target.value)}
                    />
                    <button onClick={() => handleDecision(a.approval_id, 'Approved')}>Approve</button>
                    <button onClick={() => handleDecision(a.approval_id, 'Rejected')}>Reject</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      )}
    </div>
  );
}
