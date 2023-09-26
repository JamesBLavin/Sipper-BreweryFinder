<template>
  <div class="brewery-card" @click="toggleShow">
    <h2 :class="{ 'centered': show, 'left-aligned': !show }">{{ brewery.brewery_name }}</h2>
    <h3 class="full-details" :class="{ 'centered-text': show }" v-show="show">
      <div class="left-aligned-text">
        <p>{{ brewery.contact_info }}</p>
        <p>{{ brewery.brewery_history }}</p>
        <p>{{ brewery.operating_hours }}</p>
        <p>{{ brewery.brewery_address }}</p>
      </div>
      <img :src="brewery.brewery_img_url" alt="dust" id="previewpics"/>
    </h3>
  </div>
</template>

<script>
export default {
    name: "brewery-card",
    props: {
      brewery: Object
    },
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
  margin-left: 25px;
  margin-bottom: 25px;
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
  flex-direction: row-reverse;
  align-items: center;
}

.left-align-content {
  text-align: center;
  width: 100%; 
}

.left-aligned-text {
  text-align: left;
  margin: 20px;
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

.centered-text {
  text-align: center;
}

.brewery-card {
  margin-bottom: 10px;
}

.left-aligned {
  text-align: left;
}

.centered h2.left-aligned {
  text-align: center;
}
</style>