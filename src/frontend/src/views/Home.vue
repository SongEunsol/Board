<template>
  <div class="center">
    <!-- alert section -->
    <div>
      <div class="alert alert-danger" v-if="errorMessageUpdateFlag" @click="exit">
        {{ errorMessage }}
      </div>
      <div class="alert alert-primary" v-if="completeUpdateFlag" @click="exit">
        {{ completeMessage }}
      </div>
    </div>
    <BoardWrite @processComplete="processComplete" @changeErrormessage="changeErrormessage"/>
    <hr />
    <BoardView @processComplete="processComplete" @changeErrormessage="changeErrormessage" :refreshFlag="refreshFlag" @refreshCompleteFlag="refreshCompleteFlag"/>
  </div>
</template>

<script>
import BoardWrite from "../components/BoardWrite.vue";
import BoardView from "../components/BoardView.vue";

export default {
  data() {
    return {
      errorMessage: "",
      completeMessage: "",
      errorMessageUpdateFlag: false,
      completeUpdateFlag: false,
      refreshFlag: false
    };
  },
  components: {
    BoardWrite,
    BoardView,
  },
  methods: {
    processComplete(completeMessage) {
      this.errorMessageUpdateFlag=false;
      this.completeUpdateFlag=true;
      this.refreshFlag=true;
      this.completeMessage=completeMessage;
    },
    changeErrormessage(errorMessage) {
      this.errorMessageUpdateFlag=true;
      this.completeUpdateFlag=false;
      this.errorMessage=errorMessage;
      console.log(errorMessage);
    },
    refreshCompleteFlag() {
      this.refreshFlag=false;
    },
    exit() {
      this.errorMessageUpdateFlag = false;
      this.completeUpdateFlag = false;
    }
  },
};
</script>
