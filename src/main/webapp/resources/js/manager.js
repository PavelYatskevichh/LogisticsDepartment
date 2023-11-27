document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('*[data-href]').forEach(function(element) {
        element.addEventListener('click', function() {
            window.location.href = this.getAttribute('data-href');
        });
    });
});

document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('*[data-href]').forEach(function(element) {
        element.addEventListener('mouseover', function() {
            this.style.backgroundColor = '#ddd';
        });
        element.addEventListener('mouseout', function() {
            this.style.backgroundColor = 'white';
        });
    });
});
