const multer = require("multer");

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

const fileUpload = multer({ storage: storage });

exports.fileUpload = fileUpload;
