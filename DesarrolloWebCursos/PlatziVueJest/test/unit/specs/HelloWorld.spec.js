import Vue from 'vue'
import HelloWorld from '@/components/HelloWorld'

describe('HelloWorld.vue', () => {
  test('should render correct contents', () => {
    const Constructor = Vue.extend(HelloWorld)
    const vm = new Constructor().$mount()
    expect(vm.$el.querySelector('.hello h1').textContent)
      .toEqual('Hello Vue');
  });

  test('Creando un snapshot con vue', () =>
  {
    const Constructor = Vue.extend(HelloWorld);
    const vm = new Constructor().$mount;

    expect(vm.$el).toMatchSnapshot();
  });
});
