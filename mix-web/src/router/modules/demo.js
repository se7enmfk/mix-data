import layoutHeaderAside from '@/layout/header-aside'

const meta = {auth: true}

export default {
    path: '/demo',
    name: 'demo',
    meta,
    redirect: {name: 'demo-page1'},
    component: layoutHeaderAside,
    children: (pre => [
        {path: 'page1', name: `${pre}page1`, component: () => import('@/pages/demo/page1'), meta: {...meta, title: '页面 1'}},
        {path: 'page2', name: `${pre}page2`, component: () => import('@/pages/demo/page2'), meta: {...meta, title: '页面基肷你用仍然我违反七二七六七五胖爷有我；其未来姐夫可请问留个脚印留个脚印 2'}},
        {path: 'page3', name: `${pre}page3`, component: () => import('@/pages/demo/page3'), meta: {...meta, title: '页面 3'}},
        {path: 'page4', name: `${pre}page4`, component: () => import('@/pages/demo/page4'), meta: {...meta, title: '页面 4'}}
    ])('demo-')
}
