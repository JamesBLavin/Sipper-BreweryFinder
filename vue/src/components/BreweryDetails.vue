<template>
    <tr>
        <td class="brewery-name">{{ brewery.name }}</td>
        <td class="contact-info">{{ brewery.contact }}</td>
        <td class="brewery-history">{{ brewery.history }}</td>
        <td class="brewery-hours">{{ brewery.hours }}</td>
        <td class="brewery-address">{{ brewery.address }}</td>
    </tr>
</template>

<script>
export default {
    name: 'brewery-details',
    data() {
        return {
            brewery: {
            name: "",
            contact: "",
            history: "",
            hours: "",
            address: ""
      }
    };
  }
};
</script>