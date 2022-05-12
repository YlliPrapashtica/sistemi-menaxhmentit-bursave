const conn = require("../config/mongoose");

const Schema = require("mongoose").Schema;

const scholarshipSchema = new Schema(
  {
    name: {
      type: String,
      required: true,
    },
    start_date: {
      type: Date,
      default: Date.now(),
    },
    deadline: {
      type: Date,
      required: true,
    },
    description: {
      type: String,
      required: false,
    },
    allowed_universities: {
      type: [{ type: Schema.Types.ObjectId, ref: "University" }],
      required: false,
    },
    amount: {
      type: Number,
      required: false,
    },
    publisher: {
      type: Schema.Types.ObjectId,
      ref: "User",
      select: false,
    },
  },
  { timestamps: { createdAt: "created_at" }, collection: "Scholarship" }
);

const Scholarship = conn.model("Scholarship", scholarshipSchema);

module.exports = Scholarship;
