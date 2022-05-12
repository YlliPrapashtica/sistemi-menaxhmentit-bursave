const conn = require("../config/mongoose");
const Schema = require("mongoose").Schema;

const universitySchema = new Schema(
  {
    name: {
      type: String,
      required: true,
    },
  },
  { timestamps: { createdAt: "created_at" }, collection: "University" }
);

const University = conn.model("University", universitySchema);

module.exports = University;
