const University = require("../models/University");

const listUniversity = async (req, res) => {
  try {
    const uni = await University.find();

    res.status(200).json(uni);
  } catch (err) {
    res.status(400).json(err);
  }
};

const getUniversity = async (req, res) => {
  try {
    const uni = await University.findById(req.params.id);

    res.status(200).json(uni);
  } catch (err) {
    res.status(400).json(err);
  }
};

const createUniversity = async (req, res) => {
  try {
    const uni = await University.create(req.body);

    res.status(201).json(uni);
  } catch (err) {
    res.status(400).json(err);
  }
};

const updateUniversity = async (req, res) => {
  try {
    const uni = await University.findByIdAndUpdate(req.params.id, req.body, {
      new: true,
    });

    res.status(200).json(uni);
  } catch (err) {
    res.status(400).json(err);
  }
};

const deleteUniversity = async (req, res) => {
  try {
    const uni = await University.findByIdAndDelete(req.params.id);

    res.status(200).json(uni);
  } catch (error) {
    res.status(400).json(error);
  }
};

exports.getUniversity = getUniversity;
exports.createUniversity = createUniversity;
exports.updateUniversity = updateUniversity;
exports.deleteUniversity = deleteUniversity;
exports.listUniversity = listUniversity;
