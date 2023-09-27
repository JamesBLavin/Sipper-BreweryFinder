<template>
  <div class="brewery-card" @click="toggleShow">
    <h2 :class="{ 'centered': show, 'left-aligned': !show }">{{ brewery.brewery_name }}</h2>
    <h3 class="full-details" v-show="show">
      <div class="left-side">
        <img :src="brewery.brewery_img_url" alt="dust" id="previewpics"/>
      </div>
      <div class="right-side">
        <p>{{ brewery.contact_info }}</p>
        <p>{{ brewery.brewery_history }}</p>
        <p>{{ brewery.operating_hours }}</p>
        <p>{{ brewery.brewery_address }}</p>
        <p>{{ brewery.brewery_city }}, {{ brewery.brewery_state }} {{ brewery.brewery_zip }}</p>
      </div>
    </h3>
  </div>
</template>

<script>
export default {
    name: "brewery-card",
    props: ["brewery"],
    data() {
      return {
        show: false
      }
    },
    methods: {
      toggleShow() {
        this.show = !this.show;
      }
    }
}
</script>

<style scoped>
.brewery-card:hover {
  color: brown;
  cursor: pointer;
}

#previewpics {
  width: 300px;
  border-radius: 30px;
  margin-bottom: 30px;
}

.brewery-card {
  display: flex;
  flex-direction: column;
  border-radius: 20px;
  justify-content: space-between;
  background: wheat;

}

.full-details {
  display: flex;
  flex-direction: row;
  align-items: center;
}

.left-side {
  flex: 1;
}

.right-side {
  flex: 2;
  text-align: left;
}

h2 {
  padding: 7px;
  margin-left: 20px;
}

.centered h2 {
  text-align: center;
}

.left-aligned {
  text-align: left;
}

.brewery-card {
  margin-bottom: 10px;
}

</style>