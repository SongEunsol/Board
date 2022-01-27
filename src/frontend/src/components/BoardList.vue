<template>
<div>
  <!-- board list view -->
  <div v-if="viewFlag" class="board-list-wrap">
    <div class="board-list" @click="showContent">
      <div class="info-wrap">
        <p class="number">NO. {{ list.bno }}</p>
        <p class="date">{{ list.bregdate }}</p>
      </div>
      <div class="info-wrap">
      <p class="title">{{ list.btitle }}</p>
        <span class="writer">by {{ list.bwriter }}</span>
      </div>
    </div>
    <div v-if="contentFlag" class="board-view">
      <p class="content">{{ list.bcontent }}</p>
      <div class="control">
        <button
          type="button"
          class="control-btn"
          @click="updateForm"
        >
          수정
        </button>
        <button
          type="button"
          class="control-btn"
          @click="deleteForm"
        >
          삭제
        </button>
      </div>
    </div>
  </div>
  <!-- board update view -->
  <div v-if="updateFlag" class="board-list-wrap">
    <div class="board-list">
      <div class="info-wrap">
        <p class="number">NO. {{ list.bno }}</p>
        <p class="date">{{ list.bregdate }}</p>
      </div>
      <div class="info-wrap">
        <div class="title">
          <input
            type="text"
            class="form-control"
            placeholder="제목"
            v-model="$props.list.btitle"
          />
        </div>
        <div class="control-wrap">
          <span class="writer">by 
            <input
              type="text"
              class="form-control"
              placeholder="작성자"
              v-model="$props.list.bwriter"
            />
          </span>
        </div>
      </div>
    </div>
    <div class="board-view">
      <div class="content">
        <textarea
          class="form-control"
          placeholder="내용"
          v-model="$props.list.bcontent"
        ></textarea>
          </div>
      <div class="control">
        <button
          type="button"
          class="control-btn"
          v-on:click="updateBoardById"
        >
          수정완료
        </button>
        <button
          type="button"
          class="control-btn"
          @click="cancel"
        >
          취소
        </button>
      </div>
    </div>
  </div>
  <!-- password check modal -->
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
              <div class="row mb-1">
                <div class="col-md-8">
                  <input
                    type="password"
                    class="form-control"
                    placeholder="비밀번호"
                    v-model="inputBpassword"
                  />
                </div>
                <div class="col-md-4">
                  <button
                    type="button"
                    class="btn btn-primary btn-block"
                    @click="checkBoardPwd"
                  >
                    입력
                  </button>
                </div>
              </div>
              <div class="mismatch" v-if="errorMessageFlag">
              {{ errorMessage }}
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
  name: "BoardList",
  props: {
    list: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      messages: [],
      bno: 0,
      bwriter: null,
      bpassword: null,
      inputBpassword: null,
      btitle: null,
      bcontent: null,
      bregdate: null,
      cacheWriter: null,
      cacheTitle: null,
      cacheContent: null,
      viewFlag: true,
      contentFlag: false,
      updateFlag: false,
      currentFlag: "",
      modalFlag: false,
      errorMessageFlag: false,
      errorMessage: ""
    };
  },
  methods: {
    updateForm() {
      this.cacheWriter = this.$props.list.bwriter;
      this.cacheTitle = this.$props.list.btitle;
      this.cacheContent = this.$props.list.bcontent;
      this.currentFlag = "update";
      this.modalFlag = true;
    },
    deleteForm() {
      this.currentFlag = "delete";
      this.modalFlag = true;
    },
    cancel() {
      this.$props.list.bwriter = this.cacheWriter;
      this.$props.list.btitle = this.cacheTitle;
      this.$props.list.bcontent = this.cacheContent;
      this.viewFlag = true;
      this.updateFlag = false;
    },
    exit() {
      this.modalFlag = false;
      this.errorMessageFlag = false;
      this.errorMessage = "";
    },
    showContent() {
      this.contentFlag = !this.contentFlag;
    },
    checkBoardPwd() {
      this.messages = apiList.checkBoardPwd(this.list.bno, this.inputBpassword, this.checkPwdComplete);
    },
    updateBoardById() {
      this.messages = apiList.updateBoardById(
        this.list.bno,
        this.$props.list.bwriter,
        this.$props.list.btitle,
        this.$props.list.bcontent,
        this.processComplete
      );
      this.contentFlag = false;
    },
    deleteBoardById() {
      this.messages = apiList.deleteBoardById(this.list.bno, this.processComplete);
      this.modalFlag = false;
    },
    processComplete(response) {
      if (response.data.head.state == "1") {
        this.$emit("processComplete", response.data.body);
        if(this.currentFlag == "update") {
          this.updateFlag = false;
          this.viewFlag = true;
        }
        console.log(response.data.body);
      } else {
        this.$emit("changeErrormessage", response.data.head.errorMessage);
        console.log(response.data.head.errorMessage);
      }
    },
    checkPwdComplete(response) {
      if (response.data.head.state == "1") {
        this.inputBpassword="";
        if(this.currentFlag == "update") {
          this.viewFlag = false;
          this.updateFlag = true;
          this.modalFlag = false;
        } else {
          this.deleteBoardById();
        }
      } else {
        this.errorMessage = response.data.head.errorMessage;
        this.errorMessageFlag=true;
        this.inputBpassword="";
        console.log(response.data.head.errorMessage);
      }
    }
  },
};
</script>
<style scoped>
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: table;
}
.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}
.modal-container {
  width: 300px;
  margin: 0px auto;
  padding: 20px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
  font-family: Helvetica, Arial, sans-serif;
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
.mismatch {
  text-align: left;
  color: rgba(199, 28, 28, 0.87);
  font-size: 0.9rem;
}
</style>