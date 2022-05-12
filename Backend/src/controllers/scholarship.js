const Scholarship = require("../models/Scholarship");

const listScholarships = async (req, res) => {
  try {
    const scholarships = await Scholarship.find();

    res.status(200).json(scholarships);
  } catch (err) {
    res.status(400).json(err);
  }
};

const getScholarship = async (req, res) => {
  try {
    const scholarship = await Scholarship.findById(req.params.id);

    res.status(200).json(scholarship);
  } catch (error) {
    res.status(400).json(error);
  }
};

const listUserScholarships = async (req, res) => {
  try {
    const scholarships = await Scholarship.find({ publisher: req.user._id });

    res.status(200).json(scholarships);
  } catch (err) {
    res.status(400).json(err);
  }
};

const createScholarship = async (req, res) => {
  try {
    const scholarship = await Scholarship.create({
      ...req.body,
      publisher: req.user._id,
    });

    res.status(201).json(scholarship);
  } catch (error) {
    res.status(400).json(error);
  }
};

const updateScholarship = async (req, res) => {
  try {
    const scholarship = await Scholarship.findByIdAndUpdate(
      req.params.id,
      {
        ...req.body,
        publisher: req.user._id,
      },
      { new: true }
    );

    res.status(200).json(scholarship);
  } catch (error) {
    res.status(400).json(error);
  }
};

const deleteScholarship = async (req, res) => {
  try {
    const scholarship = await Scholarship.findByIdAndDelete(req.params.id);

    res.status(200).json(scholarship);
  } catch (error) {
    res.status(400).json(error);
  }
};

exports.listUserScholarships = listUserScholarships;
exports.listScholarships = listScholarships;
exports.getScholarship = getScholarship;
exports.createScholarship = createScholarship;
exports.updateScholarship = updateScholarship;
exports.deleteScholarship = deleteScholarship;
