const {
  getScholarship,
  createScholarship,
  updateScholarship,
  deleteScholarship,
  listScholarships,
  listUserScholarships,
} = require("../controllers/scholarship");

const router = require("express").Router();
const passport = require("passport");
const { isScholarshipOwner } = require("../middleware");

router.get("/", listScholarships);
router.get(
  "/my",
  passport.authenticate("jwt", { session: false }),
  listUserScholarships
);
router.get("/:id", getScholarship);
router.post(
  "/",
  passport.authenticate("jwt", { session: false }),
  createScholarship
);
router.put(
  "/:id",
  passport.authenticate("jwt", { session: false }),
  isScholarshipOwner,
  updateScholarship
);

router.delete(
  "/:id",
  passport.authenticate("jwt", { session: false }),
  isScholarshipOwner,
  deleteScholarship
);

module.exports = router;
