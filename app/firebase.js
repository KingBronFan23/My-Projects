import { initializeApp } from 'firebase/app';
import { getFirestore } from 'firebase/firestore';

const firebaseConfig = {
    apiKey: "AIzaSyDo822CRTGlo_stHuVXvhqVvFb2CEvrPmg",
    authDomain: "project-65a87.firebaseapp.com",
    projectId: "project-65a87",
    storageBucket: "project-65a87.appspot.com",
    messagingSenderId: "396030895917",
    appId: "1:396030895917:web:2b1bf8b4ea87bd703315a4"
  };

const app = initializeApp(firebaseConfig);
const firestore = getFirestore(app);
export { firestore };