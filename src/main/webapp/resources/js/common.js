document.addEventListener('DOMContentLoaded', function() {
    let currentUrl = window.location.pathname + window.location.search;
    let links = document.querySelectorAll('.header a');
    links.forEach(function(link) {
        if (link.getAttribute('href') === currentUrl) {
            link.classList.add('active');
        }
    });
});