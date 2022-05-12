const Scholarship = require("../models/Scholarship");

const isScholarshipOwner = async (req, res, next) => {
  try {
    const scholarship = await Scholarship.findById(req.params.id).select(
      "publisher"
    );
    if (scholarship.publisher.equals(req.user._id)) {
      next();
    } else {
      res.status(403).json("Unauthorized");
    }
  } catch (err) {
    console.log(err);
    res.status(400).json(err);
  }
};

exports.isScholarshipOwner = isScholarshipOwner;
