document.addEventListener('DOMContentLoaded', function() {
    let button = document.querySelector('input[value="Create"]');

    if (button) {
        button.addEventListener('click', function() {
            let mainFormData = new FormData();
            let forms = document.querySelectorAll('form[modelAttribute]');

            forms.forEach(form => {
                let formAttribute = form.getAttribute("modelAttribute");
                let formElements = form.elements;

                for (let i = 0; i < formElements.length; i++) {
                    mainFormData.append(formAttribute + '.' + formElements[i].name, formElements[i].value);
                }
            });

            fetch('createApplication', {
                method: 'POST',
                body: mainFormData
            }).then(response => {
                if (response.ok) {
                    window.location.replace('main');
                }
            });
        });
    }
});

let numberOfItems = 1;

document.addEventListener('DOMContentLoaded', function() {
    let form = document.getElementById("itemForm1");
    let button = document.querySelector('input[value="Add another item"]');
    if (button) {
        button.addEventListener('click', function() {
            let newForm = form.cloneNode(true);
            newForm.id = "itemForm" + ++numberOfItems;

            let content = document.getElementById("content");
            let child = document.getElementById("addItem");
            content.insertBefore(newForm, child);
        });
    }
});

document.addEventListener('click', function() {
    let button = document.querySelector('input[value="Delete item"]');
    if (button) {
        button.addEventListener('click', function() {
            button.parentElement.parentElement.parentElement.remove();
        });
    }
});

document.addEventListener('DOMContentLoaded', function() {
    let button = document.querySelector('input[value="Reset"]');
    if (button) {
        button.addEventListener('click', function() {
            for (let i = 1; i <= numberOfItems; i++) {
                document.getElementById("itemForm" + i).reset();
            }
            document.getElementById("loadAdrForm").reset();
            document.getElementById("unloadAdrForm").reset();
        });
    }
});
