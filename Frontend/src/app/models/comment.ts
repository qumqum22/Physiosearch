export interface Comment {
    id: number;
    comment: string;
    commentDate: Date;
    rate: number;
    authorId: number;
    name: string;
    surname: string;
    profileImage: string;
    isEdited: boolean;
}