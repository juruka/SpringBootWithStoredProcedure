<template>
  <div>
    <h2>喜好金融商品清單</h2>
    <ul>
      <li v-for="item in financeItems" :key="item.id">
        名稱: {{ item.name }}, 價格: {{ item.price }}, 手續費率: {{ item.feeRate }}, 帳號: {{ item.account }}, 數量: {{ item.quantity }}
        <button @click="deleteFinanceItem(item.id)">刪除</button>
        <router-link :to="{ name: 'edit', params: { id: item.id }}">編輯</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
export default {

}
</script>
