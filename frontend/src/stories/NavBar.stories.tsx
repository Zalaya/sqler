import { ComponentProps } from "react";
import { Meta, StoryObj } from "@storybook/react";
import { NavBar } from "../components/layout/NavBar.tsx";

type StoryProps = ComponentProps<typeof NavBar>;

const meta: Meta<StoryProps> = {
    title: "Layout/NavBar",
    component: NavBar
};

export default meta;

type Story = StoryObj<StoryProps>;

export const Default: Story = {

};
