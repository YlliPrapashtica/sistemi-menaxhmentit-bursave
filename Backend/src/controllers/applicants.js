const Applicant = require("../models/Applicants");
const { fileUpload } = require("../config/multer");
const { default: mongoose } = require("mongoose");

const listApplications = async (req, res) => {
  try {
    const app = await Applicant.findOne();

    res.status(200).json(app);
  } catch (err) {
    res.status(400).json(err);
  }
};

const getApplication = async (req, res) => {
  try {
    let app;
    if (mongoose.Types.ObjectId.isValid(req.params.key)) {
      app = await Applicant.findOne({
        _id: req.params.key,
      });
    } else {
      app = await Applicant.findOne({
        personal_number: req.params.key,
      });
    }

    res.status(200).json(app);
  } catch (err) {
    res.status(400).json(err);
  }
};

const uploadFiles = async (req, res, next) => {
  try {
    const upload = fileUpload.fields([
      { name: "cv", maxCount: 1 },
      { name: "extra_documents", maxCount: 1 },
    ]);

    upload(req, res, function (err) {
      if (err) {
        return res.status(400).json({ message: err.message, type: "multer" });
      }
      next();
    });
  } catch (err) {
    res.status(400).json(err);
  }
};

const createApplication = async (req, res) => {
  try {
    data = {
      ...req.body,
      cv: req.files["cv"] ? req.files["cv"][0].filename : null,
      extra_documents: req.files["extra_documents"]
        ? req.files["extra_documents"][0].filename
        : null,
    };

    const app = await Applicant.create(data);

    res.status(201).json(app);
  } catch (error) {
    console.log(error);

    res.status(400).json(error);
  }
};

exports.listApplications = listApplications;
exports.getApplication = getApplication;
exports.createApplication = createApplication;
exports.uploadFiles = uploadFiles;
