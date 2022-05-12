const router = require("express").Router();
const authRouter = require("./auth");
const uniRouter = require("./university");
const scholarshipRouter = require("./scholarship");
router.use("/auth/", authRouter);

router.use("/university", uniRouter);
router.use("/scholarship", scholarshipRouter);

module.exports = router;
