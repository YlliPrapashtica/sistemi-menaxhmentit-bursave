const multer = require("multer");
const path = require("path");

const storage = multer.diskStorage({
  destination: "media/",

  filename: function (req, file, cb) {
    const uniqueSuffix = Date.now() + "-" + Math.round(Math.random() * 1e9);

    const fileContents = file.originalname.split(".");

    if (fileContents.length >= 2) {
      const filename = fileContents[0] + uniqueSuffix + "." + fileContents[1];

      cb(null, filename);
    } else {
      cb("Invalid file");
    }
  },
});

const fileUpload = multer({
  storage: storage,
  fileFilter: function (req, file, callback) {
    var ext = path.extname(file.originalname);

    if (ext !== ".pdf") {
      return callback(new Error("Only pdf files allowed"));
    }
    callback(null, true);
  },
  onError: function (err, next) {
    next(err);
  },
});

exports.fileUpload = fileUpload;
