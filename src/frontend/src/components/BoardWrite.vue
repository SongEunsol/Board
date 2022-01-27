<template>
<div>
  <!-- board write button -->
  <div class="control">
    <button
      type="button"
      class="control-btn"
      v-on:click="writeBoard"
    >
      작성하기
    </button>
  </div>
  <!-- board write view -->
  <transition name="modal" v-if="modalFlag">
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div class="modal-header">
            <slot name="header">
              <button
                type="button"
                class="close"
                data-dismiss="modal"
                aria-label="Close"
                @click="exit"
              >
                <span aria-hidden="true">&times;</span>
              </button>
            </slot>
          </div>

          <div class="modal-body">
            <slot name="body">
          <div class="board-write">
            <div class="row mb-1">
              <input
                type="text"
                class="form-control"
                placeholder="제목"
                required
                v-model="btitle"
              />
            </div>
            <div class="row mb-1">
              <textarea
                class="form-control"
                placeholder="내용"
                required
                v-model="bcontent"
              ></textarea>
            </div>
            <div class="row mb-1">
              <div class="col-md-3">
                <input
                  type="text"
                  class="form-control"
                  placeholder="작성자"
                  required
                  v-model="bwriter"
                />
              </div>
              <div class="col-md-3">
                <input
                  type="password"
                  class="form-control"
                  placeholder="비밀번호"
                  required
                  v-model="bpassword"
                />
              </div>
              <div class="col-md-3"></div>
              <div class="col-md-3">
                <button
                  type="button"
                  class="btn btn-primary btn-block"
                  v-on:click="insertBoard(insertComplete)"
                >
                  작성
                </button>
              </div>
            </div>
          </div>
            </slot>
          </div>
        </div>
      </div>
    </div>
  </transition>
</div>
</template>

<script>
import apiList from "@/apiConnector/apiConnector.js";

export default {
  name: "BoardWrite",
  data() {
    return {
      bwriter: null,
      bpassword: null,
      btitle: null,
      bcontent: null,
      modalFlag: false
    };
  },
  methods: {
    insertBoard() {
      this.messages = apiList.insertBoard(
        this.bwriter,
        this.bpassword,
        this.btitle,
        this.bcontent,
        this.processComplete
      );
      this.modalFlag = false;
    },
    processComplete(response) {
      if (response.data.head.state == "1") {
        this.clearData();
        this.$emit("processComplete", response.data.body);
        console.log(response.data.body);
      } else {
        this.$emit("changeErrormessage", response.data.head.errorMessage);
        console.log(response.data.head.errorMessage);
      }
    },
    clearData() {
      this.bwriter = "";
      this.bpassword = "";
      this.btitle = "";
      this.bcontent = "";
    },
    writeBoard() {
      this.modalFlag = true;
    },
    exit() {
      this.clearData();
      this.modalFlag = false;
    }
  },
};
</script><style scoped>
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: table;
  background-color: rgba(0, 0, 0, 0.33);
}
.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}
.modal-container {
  width: 600px;
  margin: 0px auto;
  margin-bottom: 25%;
  padding: 20px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
}
.modal-header {
  border: none;
}
.modal-header .close {
  padding: 0;
}
.modal-default-button {
  float: right;
}
</style>