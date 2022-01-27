<template>
<div>
  <div v-if="sortNewFlag" @click="sortBoardList">최신순 ▼</div>
  <div v-if="sortOldFlag" @click="sortBoardList">오래된순 ▼</div>
  <!-- board list component -->
  <div v-for="(list, bno) in messages" v-bind:key="bno">
    <BoardList :list="list" @processComplete="processComplete" @changeErrormessage="changeErrormessage"/>
  </div>
</div>
</template>

<script>
import apiList from "@/apiConnector/apiConnector.js"
import BoardList from "./BoardList.vue"

export default {
  name: "BoardView",
  props: {
    refreshFlag: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      messages: [],
      bno: 0,
      bwriter: null,
      bpassword: null,
      btitle: null,
      bcontent: null,
      bregdate: null,
      sort: "desc",
      completeMessage: "",
      errorMessage: "",
      sortNewFlag: true,
      sortOldFlag: false
    };
  },
  components: {
    BoardList
  },
  mounted() {
    this.boardList(this.sort);
  },
  watch: {
    refreshFlag: function(val) {
      if(val) {
        this.boardList();
        this.$emit("refreshCompleteFlag");
      }
    }
  },
  methods: {
    sortBoardList() {
      this.sortNewFlag = !this.sortNewFlag;
      this.sortOldFlag = !this.sortOldFlag;
      this.messages.reverse()
    },
    boardList() {
      this.messages = apiList.boardList(this.sort, this.updateMessages);
      // this.messages = apiList.boardList(this.updateMessages);
    },
    updateMessages(data) {
      this.messages = data;
    },
    processComplete(completeMessage) {
      this.$emit("processComplete", completeMessage);
      this.boardList(this.sort);
    },
    changeErrormessage(errorMessage) {
      this.$emit("changeErrormessage", errorMessage);
    }
  }
};
</script>
