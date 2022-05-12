const express = require("express");
require("dotenv").config();
const passport = require("passport");
require("./config/passport");
const indexRouter = require("./routes");

const app = express();

app.use(express.json());
app.use(passport.initialize());
app.use("/api/", indexRouter);
app.use("/media", express.static("media"));

const PORT = process.env.PORT;

app.listen(PORT, () => {
  console.log(`Server started on ${PORT}`);
});
