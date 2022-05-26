function buttonAddCourse(userID, courseID, urlServlet) {
    if (userID === "") {
        alert("Please login account!!");
    } else {
        $.ajax({
            url: urlServlet,
            type: "post",
            data: {
                UserID: userID,
                CourseID: courseID
            },
            success: function () {
                location.reload();
            }
        });
    }
}