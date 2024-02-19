// function constructor
class Employee {
    constructor(name, designation, yearofBirth) {
        this.name = name;
        this.designation = designation;
        this.yearofBirth = yearofBirth;
    }
}

Employee.prototype.calculateAge = function () {
    const currentYear = new Date().getFullYear();
    return currentYear - this.yearofBirth;
}


function submitForm() {
    const name = document.getElementById('name').value;
    const designation = document.getElementById('designation').value;
    const yearofBirth = document.getElementById('yearofbirth').value;

    const employee = new Employee(name, designation, yearofBirth);
    const age = employee.calculateAge(employee.yearofBirth);
    displayEmployeeDetails(employee, age);
}

function displayEmployeeDetails(employee, age) {
    const detailsContainer = document.getElementById('employeeDetails');

    // Create a new div to display employee details
    const detailsDiv = document.createElement('div');
    detailsDiv.innerHTML = `<h2>Employee Details</h2>
                            <p><strong>Name:</strong> ${employee.name}</p>
                            <p><strong>Designation:</strong> ${employee.designation}</p>
                            <p><strong>Year of birth:</strong>${employee.yearofBirth}</p>
                            <p><strong>Age:</strong>${age}</p>`;

    // Append the details to the container
    detailsContainer.innerHTML = '';
    detailsContainer.appendChild(detailsDiv);
}