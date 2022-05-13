const {
  getApplication,
  listApplications,
  createApplication,
  uploadFiles,
} = require("../controllers/applicants");
const router = require("express").Router();

router.get("/", listApplications);
router.post("/", uploadFiles, createApplication);
router.get("/:key", getApplication);

module.exports = router;
