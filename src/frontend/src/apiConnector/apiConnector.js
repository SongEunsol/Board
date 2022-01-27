import axios from 'axios'

var apiList = {
    boardList(sort, callback) {
        axios
            .get("/api/boardList", {
                sort: sort
            })
            .then((response) => {
                return callback(response.data.body);
            });
    },
    replyList(bno, callback) {
        axios
            .get("/api/replyList", {
                bno: bno
            })
            .then((response) => {
                return callback(response.data.body);
            });
    },
    insertBoard(bwriter, bpassword, btitle, bcontent, callback) {
        axios
            .post("/api/insertBoard", {
                bwriter: bwriter,
                bpassword: bpassword,
                btitle: btitle,
                bcontent: bcontent
            })
            .then((response) => {
                return callback(response);
            });
    },
    updateBoardById(bno, bwriter, btitle, bcontent, callback) {
        axios
            .post("/api/updateBoardById", {
                bno: bno,
                bwriter: bwriter,
                btitle: btitle,
                bcontent: bcontent
            })
            .then((response) => {
                return callback(response);
            });
    },
    deleteBoardById(bno, callback) {
        axios
            .post("/api/deleteBoardById", {
                bno: bno
            })
            .then((response) => {
                return callback(response);
            });
    },
    checkBoardPwd(bno, bpassword, callback) {
        axios
            .post("/api/checkBoardPwd", {
                bno: bno,
                bpassword: bpassword
            })
            .then((response) => {
                return callback(response);
            });
    }
}

export default apiList