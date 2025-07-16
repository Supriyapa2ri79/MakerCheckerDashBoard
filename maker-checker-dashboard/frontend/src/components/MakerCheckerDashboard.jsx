import React, { useState, useEffect } from 'react';
import './MakerCheckerDashboard.css';

export default function MakerCheckerDashboard({ userRole, userId }) {
  const [products, setProducts] = useState([]);
  const [pendingApprovals, setPendingApprovals] = useState([]);
  const [form, setForm] = useState({
    product_code: '',
    rate_of_intrest: '',
    product_id: null,
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
            <button type="submit">Submit for Approval</button>
          </form>
          <h3>My Submissions</h3>
          <table>
            <thead>
              <tr>
                <th>Product Code</th>
                <th>Rate of Interest</th>
                <th>Status</th>
                <th>Checker Comments</th>
              </tr>
            </thead>
            <tbody>
              {products.map(p => (
                <tr key={p.approval_id}>
                  <td>{p.product_code}</td>
                  <td>{p.rate_of_intrest}</td>
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
                <th>Product Code</th>
                <th>Rate of Interest</th>
                <th>Maker ID</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {pendingApprovals.map(a => (
                <tr key={a.approval_id}>
                  <td>{a.product_code}</td>
                  <td>{a.rate_of_intrest}</td>
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
