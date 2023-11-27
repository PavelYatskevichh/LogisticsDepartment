document.addEventListener('DOMContentLoaded', function() {
    var currentUrl = window.location.pathname + window.location.search;
    var links = document.querySelectorAll('.header a');
    links.forEach(function(link) {
        if (link.getAttribute('href') === currentUrl) {
            link.classList.add('active');
        }
    });
});