<template>
  <div class="brewery-card" @click="toggleShow">
    <h2 :class="{ 'centered': show, 'left-aligned': !show }">{{ brewery.brewery_name }}</h2>
    <h3 class="full-details" :class="{ 'centered-text': show }" v-show="show">
      <div class="left-aligned-text">
        {{ brewery.contact_info }}<br>
        <p>{{ brewery.brewery_history }}</p>
        {{ brewery.operating_hours }}<br>
        {{ brewery.brewery_address }}<br><br>
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
}

.brewery-card {
  display: flex;
  flex-direction: column;
  /* border-top: solid white 5px;
  border-bottom: solid white 5px; */
  border: solid orange 2px;
  border-radius: 5% / 50%;
  justify-content: space-between;
}

.full-details {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.left-align-content {
  text-align: center;
  width: 100%; /* Adjust the width as needed */
}

.left-aligned-text {
  text-align: left;
  margin: 0 20px; /* Adjust the margin as needed */
}

h2 {
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
  margin-bottom: 50px;
}

/* Additional styles to shift the name to the center */
.left-aligned {
  text-align: left;
}

.centered h2.left-aligned {
  text-align: center;
}
</style>