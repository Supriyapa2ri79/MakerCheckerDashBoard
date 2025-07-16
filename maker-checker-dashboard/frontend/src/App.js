import React from 'react';
import MakerCheckerDashboard from './components/MakerCheckerDashboard';

function App() {
  // For demo, hardcode userRole and userId
  // In real app, get from authentication/session
  const userRole = 'maker'; // or 'checker'
  const userId = 1;

  return (
    <div>
      <MakerCheckerDashboard userRole={userRole} userId={userId} />
    </div>
  );
}

export default App;
