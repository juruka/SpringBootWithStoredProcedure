<template>
  <div>
    <h2>新增喜好金融商品</h2>
    <form @submit.prevent="addFinanceItem">
      <label>產品名稱:</label>
      <input v-model="name" required>
      <label>產品價格:</label>
      <input v-model="price" type="number" required>
      <label>手續費率:</label>
      <input v-model="feeRate" type="number" required>
      <label>預計扣款帳號:</label>
      <input v-model="account" required>
      <label>購買數量:</label>
      <input v-model="quantity" type="number" required>
      <button type="submit">新增</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: '',
      price: 0,
      feeRate: 0,
      account: '',
      quantity: 0
    }
  },
  methods: {
    addFinanceItem() {
      const newItem = {
        name: this.name,
        price: this.price,
        feeRate: this.feeRate,
        account: this.account,
        quantity: this.quantity
      };
      this.$store.dispatch('addFinanceItem', newItem);
      this.name = '';
      this.price = 0;
      this.feeRate = 0;
      this.account = '';
      this.quantity = 0;
    }
  }
}
</script>
