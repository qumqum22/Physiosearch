export interface User {
    id: number;
    title:string;
    name: string;
    surname: string;
    gender:string;
    birthday: Date;
    profileImage: "assets/images/default-profile.jpg";
    description:string;
    physioID: string;
    person: string;
}