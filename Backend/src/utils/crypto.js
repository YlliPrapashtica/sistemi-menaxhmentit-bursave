const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");
const SALT_ROUNDS = parseInt(process.env.SALT_ROUNDS);
const hashPassword = async (password) => {
  return await bcrypt.hash(password, SALT_ROUNDS);
};

const generateJwt = (payload, expires = "1 day") => {
  return jwt.sign(payload, process.env.APP_SECRET, { expiresIn: expires });
};

exports.generateJwt = generateJwt;
exports.hashPassword = hashPassword;
