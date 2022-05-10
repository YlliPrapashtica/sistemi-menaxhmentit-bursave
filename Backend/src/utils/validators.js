const ALLOWED_EMAIL_DOMAINS = [
  "uni-pr.edu",
  "universitetiaab.com",
  "ubt-uni.net",
  "unhz.eu",
];

const validateUniversityEmail = (email) => {
  const emailContents = email.split("@");

  if (emailContents.length > 0) {
    const domain = emailContents[1];

    if (!ALLOWED_EMAIL_DOMAINS.includes(domain)) return false;

    return true;
  }
  return false;
};

exports.validateUniversityEmail = validateUniversityEmail;
