const { app, BrowserWindow, ipcMain } = require('electron');
const path = require('path');
const axios = require('axios');

let mainWindow;

app.on('ready', () => {
    mainWindow = new BrowserWindow({
        width: 800,
        height: 600,
        resizable: false,
        webPreferences: {
            preload: path.join(__dirname, 'preload.js'),
        },
        icon: path.join(__dirname, './assets/default-icon.png'),
    });

    mainWindow.loadFile('index.html');
    mainWindow.webContents.openDevTools();
});

ipcMain.on('get-jars', async (event) => {
    const response = await axios.get('http://localhost:4567/jars');
    event.reply('update-jar-list', response.data);
});

ipcMain.on('import-jar', async (event, jarPath) => {
    const response = await axios.post('http://localhost:4567/import', null, {
        params: { path: jarPath }
    });
    event.reply('import-status', response.data);
});

// ipcMain.on('delete-jar', async (event, jarName) => {
//     const response = await axios.delete('http://localhost:4567/delete', {
//         params: { name: jarName }
//     });
//     event.reply('delete-status', response.data);
// });

ipcMain.on('run', async (event, jarName) => {
    // open a new window to run the jar
    const response = await axios.post('http://localhost:4567/run', null, {
        params: { name: jarName }
    });
    event.reply('run-status', response.data);
});
