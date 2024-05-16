const lendStatsData = {
    returned: 10,
    notReturned: 5
  };

  // Chart.js Konfiguration
  const ctx = document.getElementById('lendStatsChart').getContext('2d');
  const lendStatsChart = new Chart(ctx, {
    type: 'pie',
    data: {
      labels: ['Returned', 'Not Returned'],
      datasets: [{
        label: 'Lend Stats',
        data: [lendStatsData.returned, lendStatsData.notReturned],
        backgroundColor: ['#4CAF50', '#FF6384']
      }]
    },
    options: {
      responsive: true,
      plugins: {
        legend: {
          position: 'top'
        },
        title: {
          display: true,
          text: 'Lend Return Statistics'
        }
      }
    }
  });