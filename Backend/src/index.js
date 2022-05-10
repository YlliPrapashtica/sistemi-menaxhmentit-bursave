const express = require("express");
require("dotenv").config();

const app = express();

app.get("/", async (req, res) => {
  res.json({ message: "Hello world" });
});

app.listen(process.env.PORT, () => {
  console.log(`Server started on port ${process.env.PORT}`);
});
