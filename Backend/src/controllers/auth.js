const User = require("../models/User");
var passport = require("passport");
const { generateJwt } = require("../utils/crypto");

const login = (req, res) => {
  passport.authenticate(
    "local",
    { session: false },
    function (err, user, info) {
      if (!user) {
        res.status(401);
        return res.json(info);
      }

      const token = generateJwt({ id: user._id });

      return res.json({ user, token });
    }
  )(req, res);
};

const register = async (req, res) => {
  try {
    await User.create({ ...req.body });

    res.status(201).json({ message: "User created please log in" });
  } catch (error) {
    console.log(error);
    res.status(400).json(error);
  }
};

const getUser = (req, res) => {
  passport.authenticate("jwt", { session: false }, function (err, user, info) {
    if (!user) {
      res.status(401);
      return res.json(info);
    }

    return res.json({ user });
  })(req, res);
};

exports.login = login;
exports.register = register;
exports.getUser = getUser;
