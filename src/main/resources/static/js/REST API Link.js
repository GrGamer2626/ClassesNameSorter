document.addEventListener('DOMContentLoaded', () => {
    const copyButton = document.getElementById('copyButton');
    const apiLink = `${window.location.origin}/api/courses`;

    copyButton.addEventListener('click', () => {
        navigator.clipboard.writeText(apiLink)
            .then(() => alert('Link do API został skopiowany.'))
            .catch(err => alert('Wystąpił błąd podczas kopiowania linku: ' + err));
    });
});