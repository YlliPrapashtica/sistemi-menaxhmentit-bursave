const mongoose = require("mongoose");

const conn = mongoose.createConnection(
  `mongodb+srv://${process.env.DB_USER}:${process.env.DB_PASS}@bursa-system.dhhsk.mongodb.net/${process.env.DB_NAME}?retryWrites=true&w=majority`,
  (err) => {
    if (err) {
      console.log("Error in database connection:");
      console.log(err);
    } else {
      console.log("Database connected");
    }
  }
);

module.exports = conn;
