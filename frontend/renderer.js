const { ipcRenderer, shell } = require('electron');

document.addEventListener('DOMContentLoaded', () => {
    ipcRenderer.send('get-jars');
});

ipcRenderer.on('update-jar-list', (event, jars) => {
    const jarList = document.getElementById('jarList');
    jarList.innerHTML = jars.map(jar => `<div>${jar}</div>`).join('');
});

function importJar() {
    const jarPath = document.getElementById('jarInput').files[0].path;
    ipcRenderer.send('import-jar', jarPath);
}

function runJar(jarId) {
    // open new window to run the jar
}

function openInBrowser(url) {
    shell.openExternal(url);
}