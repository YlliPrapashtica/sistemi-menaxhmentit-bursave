const { login, register, getUser } = require("../controllers/auth");

const router = require("express").Router();

router.get("/", getUser);
router.post("/login", login);
router.post("/register", register);
router.post("/register", register);

module.exports = router;
