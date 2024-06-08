const express = require('express');
const cors = require('cors');
const path = require('path');

const app = express();
const PORT = 80;

// Define o diretório onde as páginas HTML estão localizadas
const publicDirectoryPath = path.join(__dirname, '');

// Define a pasta pública
app.use(express.static(publicDirectoryPath));
app.use(cors());

// Rota para a página principal
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'index.html'));
});

// Inicia o servidor
app.listen(PORT, () => {
    console.log(`Servidor está executando na porta ${PORT}`);
});
