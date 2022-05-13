const router = require("express").Router();
const authRouter = require("./auth");
const uniRouter = require("./university");
const scholarshipRouter = require("./scholarship");
const applicationRouter = require("./applicant");
router.use("/auth/", authRouter);

router.use("/university", uniRouter);
router.use("/scholarship", scholarshipRouter);
router.use("/applicant", applicationRouter);
module.exports = router;
