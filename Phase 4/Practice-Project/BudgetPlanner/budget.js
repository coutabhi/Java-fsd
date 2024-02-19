// IIFE for encapsulation
(function () {
    // Deal constructor function
    function Deal(name, vendor, expense) {
        this.name = name;
        this.vendor = vendor;
        this.expense = expense;
    }

    // Array to store deals
    const deals = [];

    // Function to calculate annual budget
    function calculateAnnualBudget(deals) {
        const multiplier = 1.2;
        const totalExpense = deals.reduce((acc, deal) => acc + deal.expense, 0);
        return totalExpense * multiplier;
    }

    // Function to add a new deal
    function addDeal() {
        const dealName = document.getElementById('dealName').value;
        const vendor = document.getElementById('vendor').value;
        const expense = parseFloat(document.getElementById('expense').value);

        if (!isNaN(expense)) {
            const newDeal = new Deal(dealName, vendor, expense);
            deals.push(newDeal);
            updateBudgetResult();
            displayDealsTable();
            clearForm();
        } else {
            alert('Please enter a valid expense amount.');
        }
    }

    // Function to update the display with the total annual budget
    function updateBudgetResult() {
        const annualBudget = calculateAnnualBudget(deals);
        const budgetResultDiv = document.getElementById('budgetResult');
        budgetResultDiv.innerHTML = `<h2>Annual Budget:</h2>
                                     <p>Total Expense: $${annualBudget.toFixed(2)}</p>`;
    }

    // Function to display added deals in a table
    function displayDealsTable() {
        const dealTableBody = document.getElementById('dealTableBody');
        dealTableBody.innerHTML = '';

        deals.forEach(deal => {
            const row = document.createElement('tr');
            row.innerHTML = `<td>${deal.name}</td>
                             <td>${deal.vendor}</td>
                             <td>${deal.expense.toFixed(2)}</td>`;
            dealTableBody.appendChild(row);
        });
    }

    // Function to clear the form after adding a deal
    function clearForm() {
        document.getElementById('dealName').value = '';
        document.getElementById('vendor').value = '';
        document.getElementById('expense').value = '';
    }

    // Event listener for the "Add Deal" button
    document.getElementById('addDealBtn').addEventListener('click', addDeal);

})();
