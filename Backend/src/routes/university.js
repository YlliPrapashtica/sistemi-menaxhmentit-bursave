const {
  getUniversity,
  createUniversity,
  updateUniversity,
  deleteUniversity,
  listUniversity,
} = require("../controllers/university");

const passport = require("passport");

const router = require("express").Router();

router.get("/", listUniversity);

router.get("/:id", getUniversity);
router.post(
  "/",
  passport.authenticate("jwt", { session: false }),
  createUniversity
);
router.put(
  "/:id",
  passport.authenticate("jwt", { session: false }),
  updateUniversity
);
router.delete(
  "/:id",
  passport.authenticate("jwt", { session: false }),
  deleteUniversity
);

module.exports = router;
