const conn = require("../config/mongoose");
const bcrypt = require("bcrypt");
const Schema = require("mongoose").Schema;
const { hashPassword } = require("../utils/crypto");
const userSchema = new Schema(
  {
    email: {
      type: String,
      required: true,
      unique: true,
      validate: {
        validator: async function (value) {
          const num = await this.constructor.count({ email: value }).exec();
          return !(num > 0);
        },
        message: "Email already in use",
      },
    },
    password: {
      type: String,
      required: true,
      select: false,
    },
  },
  { collection: "User" }
);

userSchema.methods.checkPassword = async function (password) {
  try {
    const match = await bcrypt.compare(password, this.password);
    return match;
  } catch (err) {
    return false;
  }
};

userSchema.pre("save", async function (next) {
  const user = this;

  if (user.isNew) {
    user.password = await hashPassword(user.password);

    return next();
  }

  next();
});

const User = conn.model("User", userSchema);

module.exports = User;
