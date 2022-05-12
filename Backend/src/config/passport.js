var passport = require("passport");
var LocalStrategy = require("passport-local").Strategy;
var JwtStrategy = require("passport-jwt").Strategy;
var ExtractJwt = require("passport-jwt").ExtractJwt;
const User = require("../models/User");

passport.use(
  new LocalStrategy(
    { usernameField: "email", passwordField: "password" },
    async function (email, password, cb) {
      let user;
      try {
        user = await User.findOne({ email: email }).select("password");
        if (!user) {
          return cb(null, false, { message: "Incorrect email or password" });
        }
      } catch (err) {
        cb(err);
      }

      const match = await user.checkPassword(password);
      if (!match) {
        return cb(null, false, { message: "Incorrect email or password" });
      }

      user = await User.findOne({ email: email });

      return cb(null, user);
    }
  )
);

passport.use(
  new JwtStrategy(
    {
      jwtFromRequest: ExtractJwt.fromAuthHeaderAsBearerToken(),
      secretOrKey: process.env.APP_SECRET,
      algorithms: ["HS256"],
    },
    async function (payload, done) {
      try {
        const user = await User.findOne({ _id: payload.id });

        if (user) {
          return done(null, user);
        }
        return done(null, false);
      } catch (err) {
        return done(err, false);
      }
    }
  )
);
