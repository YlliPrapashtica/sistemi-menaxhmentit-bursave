const conn = require("../config/mongoose");
const { validateUniversityEmail } = require("../utils/validators");
const Schema = require("mongoose").Schema;
const path = require("path")
const applicantSchema = new Schema(
  {
    first_name: {
      type: String,
      required: true,
    },
    last_name: {
      type: String,
      required: true,
    },
    personal_number: {
      type: String,
      required: true,
      unique: true,
      trim: true,
      lowercase: true,
      match: [/^[0-9]+$/, "Please provide a valid personal number"],
      validate: {
        validator: async function (value) {
          const num = await this.constructor
            .count({ personal_number: value })
            .exec();
          return !(num > 0);
        },
        message: "Personal number not valid try another one",
      },
    },
    student_card_number: {
      type: String,
      required: true,
      trim: true,
      lowercase: true,
    },
    email: {
      type: String,
      required: true,
      trim: true,
      lowercase: true,
      match: [
        /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/,
        "Please provide a valid email",
      ],
      validate: {
        validator: async function (value) {
          const num = await this.constructor.count({ email: value }).exec();
          return !(num > 0);
        },
        message: "Email not valid try another one",
      },
      unique: true,
      validate: [validateUniversityEmail, "Email must be a University email"],
    },
    phone: {
      type: String,
      required: true,
    },
    university: {
      type: Schema.Types.ObjectId,
      required: true,
      ref: "Univeristy",
    },
    faculty: {
      type: String,
      required: true,
    },
    scholarship: {
      type: Schema.Types.ObjectId,
      ref: "Scholarship",
      required: true,
    },
    cv: {
      type: String,
      required: true,
      get: function (value) {
    return path.normalize(path.resolve(`./media/${value}`));
      },
    },
    extra_documents: {
      type: String,
      required: true,
      get: function (value) {
        return path.normalize(path.resolve(`./media/${value}`));
      },
    },
  },
  {
    timestamps: { createdAt: "created_at", updatedAt: "updated_at" },
    collection: "Applicant",
    toObject: { getters: true },
    toJSON: { getters: true },
  }
);

applicantSchema.virtual("fullname").get(function () {
  return `${this.first_name} ${this.last_name}`;
});

const Applicant = conn.model("Applicant", applicantSchema);

module.exports = Applicant;
